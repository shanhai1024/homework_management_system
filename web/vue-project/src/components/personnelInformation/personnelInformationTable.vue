<template>
  <div class="home">
    <el-table :data="tableData()" style="width: 100%">
      <el-table-column type="index" label="id" width="50" />
      <el-table-column prop="name" label="名字" width="180" />
      <el-table-column prop="gender" label="性别" width="180" />
      <el-table-column prop="phoneNumber" label="电话" width="280" />
      <el-table-column prop="email" label="邮箱" width="280" />
      <el-table-column prop="job" label="职业" width="180" />
      <el-table-column label="操作">
        <template #default="scope">
          <el-button @click="handleEdit(scope.$index, scope.row)" type="primary" size="small">编辑</el-button>
          <el-button @click="handleDelete(scope.$index, scope.row)" type="danger" size="small">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <div class="example-pagination-block">
      <el-pagination
          background
          layout="prev, pager, next, total, sizes"
          :total="total"
          @current-change="handleCurrentChange"
          @size-change="handleSizeChange"
      />
    </div>

    <!-- 编辑对话框 -->
    <el-dialog  v-model="editDialogVisible" title="编辑信息">
      <el-form :model="editForm">
        <el-form-item label="名字">
          <el-input v-model="editForm.name"></el-input>
        </el-form-item>
        <el-form-item label="性别">
          <el-input v-model="editForm.gender"></el-input>
        </el-form-item>
        <el-form-item label="电话">
          <el-input v-model="editForm.phoneNumber"></el-input>
        </el-form-item>
        <el-form-item label="邮箱">
          <el-input v-model="editForm.email"></el-input>
        </el-form-item>
        <el-form-item label="职业">
          <el-input v-model="editForm.job"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="editDialogVisible = false">取消</el-button>
        <el-button type="primary" @click="saveEdit">保存</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script lang="ts">
import { defineComponent, reactive, toRefs } from "vue";
import { ElMessageBox, ElMessage } from "element-plus";
import {getToken} from "@/stores/auth.js";
import axios from 'axios';
import FormData  from "form-data"
let data = new FormData();

export default defineComponent({
  name: "personnelInformationTable",
  setup() {
    const allTableData = reactive([
      { id: 1, date: "2016-05-03", name: "Tom", gender: "男", phoneNumber: "1234567890", email: "tom@example.com", job: "后勤" },
      { id: 2, date: "2016-05-02", name: "Jerry", gender: "女", phoneNumber: "0987654321", email: "jerry@example.com", job: "老师" },
      { id: 3, date: "2017-01-23", name: "Alice", gender: "女", phoneNumber: "1231231234", email: "alice@example.com", job: "学生" },
      { id: 4, date: "2018-11-14", name: "Bob", gender: "男", phoneNumber: "9876543210", email: "bob@example.com", job: "食堂经理" },
      { id: 5, date: "2018-1-14", name: "Bob", gender: "男", phoneNumber: "9876543210", email: "bob@example.com", job: "学生" },
      { id: 6, date: "2018-6-18", name: "lisi", gender: "男", phoneNumber: "9876543210", email: "lisi@example.com", job: "老师" },
      { id: 7, date: "2018-3-24", name: "Bob", gender: "男", phoneNumber: "9876543210", email: "bob@example.com", job: "食堂经理" },
      { id: 8, date: "2018-1-28", name: "Bob", gender: "男", phoneNumber: "9876543210", email: "bob@example.com", job: "食堂经理" },
      { id: 9, date: "2018-1-28", name: "Bob", gender: "男", phoneNumber: "9876543210", email: "bob@example.com", job: "食堂经理" },
      { id: 10, date: "2018-1-28", name: "Bob", gender: "男", phoneNumber: "9876543210", email: "bob@example.com", job: "食堂经理" },
      { id: 11, date: "2018-1-28", name: "Bob", gender: "男", phoneNumber: "9876543210", email: "bob@example.com", job: "食堂经理" },
      { id: 12, date: "2018-7-17", name: "Bob", gender: "男", phoneNumber: "9876543210", email: "bob@example.com", job: "食堂经理" },

    ]);

    const state = reactive({
      page: 1,
      limit: 10,
      total: allTableData.length,
      editDialogVisible: false,
      editForm: { id: null, name: "", gender: "", phoneNumber: "", email: "", job: "" },
    });

    const tableData = () => {
      return allTableData.filter(
          (item, index) => index < state.page * state.limit && index >= state.limit * (state.page - 1)
      );
    };

    const handleCurrentChange = (e) => { state.page = e; };
    const handleSizeChange = (e) => { state.limit = e; };

    const handleEdit = (index, row) => {
      state.editForm = { ...row };
      state.editDialogVisible = true;
    };

    const saveEdit = () => {
      const index = allTableData.findIndex(item => item.id === state.editForm.id);
      if (index !== -1) {
        allTableData[index] = { date: allTableData[index].date, ...state.editForm };
        ElMessage.success('编辑成功');
        console.log('Edited Row Data:', state.editForm); // 打印编辑的行数据
      }
      state.editDialogVisible = false;
    };

    const handleDelete = (index, row) => {
      ElMessageBox.confirm('此操作将永久删除该记录, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        allTableData.splice(index, 1);
        state.total = allTableData.length;
        ElMessage.success('删除成功'+index);
        deletePersonnel(index);
        console.log('Updated Data:', allTableData); // 打印所有的数据
      }).catch(() => {
        ElMessage.info('取消删除');
      });
    };

    return {
      tableData,
      handleCurrentChange,
      handleSizeChange,
      handleEdit,
      saveEdit,
      handleDelete,
      ...toRefs(state),
    };
  },
});



function deletePersonnel(id){
  let config = {
    method: 'delete',
    maxBodyLength: Infinity,
    url: `http://127.0.0.1:8080/api/v1/deletePersonnel/{id}`,
    headers: {
      'token': getToken,
        ...data.getHeaders()
    },
    data : data
  };

  axios.request(config)
      .then((response) => {
        console.log(JSON.stringify(response.data));
      })
      .catch((error) => {
        console.log(error);
      });

}
</script>

<style scoped>
.home {
  height: 100vh;
  width: 100vw;
  padding: 20px;
  box-sizing: border-box;
}

.el-table {
  margin-bottom: 20px;
}

.example-pagination-block {
  text-align: center;
}

.el-dialog {
  z-index: 2000; /* 增加 z-index */
}
</style>

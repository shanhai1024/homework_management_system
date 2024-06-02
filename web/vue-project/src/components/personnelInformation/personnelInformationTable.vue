<template>
  <div class="home">
    <!-- 搜索输入框 -->
    <el-input v-model="searchQuery" placeholder="搜索..." style="margin-bottom: 20px; width: 300px;"></el-input>

    <el-table :data="filteredData" style="width: 100%">
      <el-table-column prop="id" label="ID" width="50" />
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
    <el-dialog v-model="editDialogVisible" title="编辑信息">
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

<script>
import { defineComponent, reactive, toRefs, onMounted, computed } from "vue";
import { ElMessageBox, ElMessage } from "element-plus";
import axios from 'axios';
import {getToken} from "@/stores/auth.js";

export default defineComponent({
  name: "personnelInformationTable",
  setup() {
    const state = reactive({
      allTableData: [],
      page: 1,
      limit: 10,
      total: 0,
      searchQuery: '',
      editDialogVisible: false,
      editForm: { id: null, name: "", gender: "", phoneNumber: "", email: "", job: "" },
    });

    const tableData = () => {
      return state.allTableData.filter(
          (item, index) => index < state.page * state.limit && index >= state.limit * (state.page - 1)
      );
    };

    const filteredData = computed(() => {
      if (!state.searchQuery) {
        return tableData();
      }
      return tableData().filter(item => {
        return Object.values(item).some(val =>
            String(val).toLowerCase().includes(state.searchQuery.toLowerCase())
        );
      });
    });

    const handleCurrentChange = (e) => { state.page = e; };
    const handleSizeChange = (e) => { state.limit = e; };

    const handleEdit = (index, row) => {
      state.editForm = { ...row };
      state.editDialogVisible = true;
    };

    const saveEdit = () => {
      const index = state.allTableData.findIndex(item => item.id === state.editForm.id);
      if (index !== -1) {
        state.allTableData[index] = { ...state.editForm };
        ElMessage.success('编辑成功');
      }
      state.editDialogVisible = false;
    };

    const handleDelete = (index, row) => {
      ElMessageBox.confirm('此操作将永久删除该记录, 是否继续?', '提示',
          {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning'
          }
      ).then(() => {
        state.allTableData.splice(index, 1);
        state.total = state.allTableData.length;
        ElMessage.success('删除成功');
        deletePersonnel(row.id);
      }).catch(() => {
        ElMessage.info('取消删除');
      });
    };

    const deletePersonnel = (id) => {
      axios.delete(`${import.meta.env.VITE_BASE_URL}/deletePersonnel/${id}`, {
        headers: {
          'token': getToken()
        }
      })
          .then((response) => {
            console.log(response.data);
          })
          .catch((error) => {
            console.log(error);
          });
    };

    const fetchPersonnelData = () => {
      axios.get(`${import.meta.env.VITE_BASE_URL}/getAllPersonnelData`, {
        headers: {
          'token': getToken()
        }
      })
          .then(response => {
            const { data } = response.data;
            state.allTableData = data.map(item => ({
              id: item[0],
              name: item[1],
              gender: item[2],
              email: item[3],
              phoneNumber: item[4],
              job: item[6],
            }));
            state.total = state.allTableData.length;
          })
          .catch(error => {
            console.error('Failed to fetch personnel data:', error);
          });
    };

    onMounted(() => {
      fetchPersonnelData();
    });

    return {
      ...toRefs(state),
      filteredData,
      handleCurrentChange,
      handleSizeChange,
      handleEdit,
      saveEdit,
      handleDelete,
    };
  },
});
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

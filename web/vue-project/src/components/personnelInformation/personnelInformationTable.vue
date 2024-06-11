<template>
  <div class="home">
    <!-- 搜索输入框 -->
    <el-row :gutter="20">
      <el-col :span="15">
        <el-input v-model="searchQuery" placeholder="输入名字搜索" style="margin-bottom: 20px; width: 50%;"></el-input>
      </el-col>
      <el-col :span="6" style="display: flex; justify-content: flex-end;">
        <el-button type="primary" :icon="Plus" circle @click="showAddDialog" />
      </el-col>
    </el-row>

    <el-table v-loading="loading" :data="filteredData" style="width: 100%">
      <el-table-column prop="id" label="ID" />
      <el-table-column prop="name" label="名字" />
      <el-table-column prop="gender" label="性别" />
      <el-table-column prop="phoneNumber" label="电话" />
      <el-table-column prop="email" label="邮箱" />
      <el-table-column prop="job" label="职业" />
      <el-table-column prop="category" label="分类" />
      <el-table-column label="操作">
        <template #default="scope">
          <el-button @click="handleEdit(scope.$index, scope.row)" type="primary" :icon="Edit" circle />
          <el-button @click="handleDelete(scope.$index, scope.row)" type="danger" :icon="Delete" circle />
        </template>
      </el-table-column>
    </el-table>
    <div class="example-pagination-block">
      <el-pagination
          background
          layout="prev, pager, next, total, sizes"
          :total="total"
          :page-size="limit"
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

    <!-- 添加对话框 -->
    <el-dialog v-model="addDialogVisible" title="添加用户">
      <el-form :model="addForm">
        <el-form-item label="名字">
          <el-input v-model="addForm.name"></el-input>
        </el-form-item>
        <el-form-item label="性别">
          <el-input v-model="addForm.gender"></el-input>
        </el-form-item>
        <el-form-item label="电话">
          <el-input v-model="addForm.phoneNumber"></el-input>
        </el-form-item>
        <el-form-item label="邮箱">
          <el-input v-model="addForm.email"></el-input>
        </el-form-item>
        <el-form-item label="职业">
          <el-input v-model="addForm.job"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="addDialogVisible = false">取消</el-button>
        <el-button type="primary" @click="saveAdd">添加</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { defineComponent, reactive, toRefs, onMounted, computed } from "vue";
import { ElMessageBox, ElMessage } from "element-plus";
import axios from "axios";
import { getToken } from "@/stores/auth.js";
import { Delete, Edit, Plus } from "@element-plus/icons-vue";

export default defineComponent({
  name: "PersonnelInformationTable",
  components: {
    Plus,
    Delete,
    Edit,
  },
  setup() {
    const state = reactive({
      allTableData: [],
      page: 1,
      limit: 10,
      total: 0,
      searchQuery: "",
      loading: false,
      editDialogVisible: false,
      addDialogVisible: false,
      editForm: { id: null, name: "", gender: "", phoneNumber: "", email: "", job: "", category: "" },
      addForm: { name: "", gender: "", phoneNumber: "", email: "", job: "", category: "" },
    });

    const filteredData = computed(() => {
      if (!state.searchQuery) {
        return state.allTableData;
      }
      return state.allTableData.filter((item) => {
        return Object.values(item).some((val) =>
            String(val).toLowerCase().includes(state.searchQuery.toLowerCase())
        );
      });
    });

    const handleCurrentChange = (e) => {
      state.page = e;
      fetchPersonnelData();
    };

    const handleSizeChange = (e) => {
      state.limit = e;
      fetchPersonnelData();
    };

    const handleEdit = (index, row) => {
      state.editForm = { ...row };
      state.editDialogVisible = true;
    };

    const saveEdit = () => {
      const index = state.allTableData.findIndex((item) => item.id === state.editForm.id);
      if (index !== -1) {
        state.allTableData[index] = { ...state.editForm };
        ElMessage.success("编辑成功");
      }
      state.editDialogVisible = false;
    };

    const handleDelete = (index, row) => {
      ElMessageBox.confirm("此操作将永久删除该记录, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
          .then(() => {
            state.allTableData.splice(index, 1);
            state.total = state.allTableData.length;
            ElMessage.success("删除成功");
            deletePersonnel(row.id);
          })
          .catch(() => {
            ElMessage.info("取消删除");
          });
    };

    const deletePersonnel = (id) => {
      axios
          .delete(`${import.meta.env.VITE_BASE_URL}/deletePersonnel/${id}`, {
            headers: {
              token: getToken(),
            },
          })
          .then((response) => {
            console.log(response.data);
          })
          .catch((error) => {
            console.log(error);
          });
    };

    const fetchPersonnelData = () => {
      state.loading = true;
      axios
          .get(`${import.meta.env.VITE_BASE_URL}/getAllPersonnelData`, {
            params: {
              page: state.page - 1,
              size: state.limit,
            },
            headers: {
              token: getToken(),
            },
          })
          .then((response) => {
            console.log('Response:', response);  // 调试信息
            const data = response.data.data;
            if (data && data.content) {
              state.allTableData = data.content.map((item) => ({
                id: item[0],
                name: item[1],
                gender: item[2],
                email: item[3],
                phoneNumber: item[4],
                job: item[5],
                category: item[6]
              }));
              state.total = data.totalElements || 0;
            } else {
              console.error('Invalid data format:', data);
            }
          })
          .catch((error) => {
            console.error('Failed to fetch personnel data:', error);
          })
          .finally(() => {
            state.loading = false;
          });
    };

    const showAddDialog = () => {
      state.addDialogVisible = true;
    };

    const saveAdd = () => {
      const data = JSON.stringify({
        name: state.addForm.name,
        sex: state.addForm.gender,
        phoneNumber: state.addForm.phoneNumber,
        email: state.addForm.email,
        classId: 1, // 需要根据实际情况设置
        category: {
          id: 1,
          name: "Category1",
        },
        personnelClass: {
          id: 1,
          name: "Class1",
        },
      });

      axios
          .post(`${import.meta.env.VITE_BASE_URL}/addPersonnel`, data, {
            headers: {
              "Content-Type": "application/json",
              token: getToken(),
            },
          })
          .then((response) => {
            console.log(JSON.stringify(response.data));
            state.allTableData.push(response.data);
            state.total = state.allTableData.length;
            ElMessage.success("添加成功");
          })
          .catch((error) => {
            console.log(error);
            ElMessage.error("添加失败");
          })
          .finally(() => {
            state.addDialogVisible = false;
            state.addForm = { name: "", gender: "", phoneNumber: "", email: "", job: "", category: "" };
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
      showAddDialog,
      saveAdd,
      limit: state.limit, // Ensure `limit` is returned
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
  z-index: 2000;
}
</style>

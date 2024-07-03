<template>
  <div class="personnel-information-table">
    <!-- 搜索输入框 -->
    <el-row :gutter="20">
      <el-col :span="15">
        <el-input v-model="searchQuery" placeholder="输入班级名称搜索" style="margin-bottom: 20px; width: 50%;"></el-input>
      </el-col>
      <el-col :span="6" style="display: flex; justify-content: flex-end;">
        <el-button type="primary" :icon="Plus" circle @click="showAddDialog"></el-button>
      </el-col>
    </el-row>

    <!-- 表格 -->
    <el-table :data="filteredData" style="width: 100%" v-loading="loading">
      <el-table-column prop="id" label="ID"></el-table-column>
      <el-table-column prop="className" label="班级名称"></el-table-column>
      <el-table-column prop="counselor" label="班主任"></el-table-column>
      <el-table-column label="操作">
        <template #default="{ row }">
          <el-button @click="handleEdit(row)" type="primary" :icon="Edit" circle></el-button>
          <el-button @click="handleDelete(row)" type="danger" :icon="Delete" circle></el-button>
        </template>
      </el-table-column>
    </el-table>

    <!-- 分页 -->
    <div class="pagination-block">
      <el-pagination
          background
          layout="prev, pager, next, total, sizes"
          :total="total"
          :page-size="limit"
          @current-change="handleCurrentChange"
          @size-change="handleSizeChange"
      ></el-pagination>
    </div>

    <!-- 编辑对话框 -->
    <el-dialog v-model="editDialogVisible" title="编辑班级">
      <el-form :model="editForm" label-width="80px">
        <el-form-item label="班级名称">
          <el-input v-model="editForm.className"></el-input>
        </el-form-item>
        <el-form-item label="班主任">
          <el-input v-model="editForm.counselor"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="editDialogVisible = false">取消</el-button>
        <el-button type="primary" @click="saveEdit">保存</el-button>
      </div>
    </el-dialog>

    <!-- 添加对话框 -->
    <el-dialog v-model="addDialogVisible" title="添加班级">
      <el-form :model="addForm" label-width="80px">
        <el-form-item label="班级名称">
          <el-input v-model="addForm.className"></el-input>
        </el-form-item>
        <el-form-item label="辅导员">
          <el-input v-model="addForm.counselor"></el-input>
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
import {defineComponent, reactive, toRefs, onMounted, computed} from "vue";
import {ElMessageBox, ElMessage} from "element-plus";
import axios from "axios";
import {getToken} from "@/stores/auth.js";
import {Delete, Edit, Plus} from "@element-plus/icons-vue";

export default defineComponent({
  name: "PersonnelInformationTable",
  computed: {
    Plus() {
      return Plus;
    },
    Delete() {
      return Delete;
    },
    Edit() {
      return Edit;
    }
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
      editForm: {id: null, className: "", counselor: ""},
      addForm: {className: "", counselor: ""},
    });

    const fetchPersonnelData = () => {
      state.loading = true;
      axios
          .get(`${import.meta.env.VITE_BASE_URL}/studentClass`, {
            params: {
              page: state.page - 1,
              limit: state.limit,
            },
            headers: {
              token: getToken(),
            },
          })
          .then((response) => {
            const data = response.data.data;
            if (Array.isArray(data)) {
              state.allTableData = data.map((item) => ({
                id: item.id,
                className: item.className,
                counselor: item.counselor,
              }));
              state.total = data.length;
            } else {
              console.error("Invalid data format:", data);
            }
          })
          .catch((error) => {
            console.error("Failed to fetch personnel data:", error);
          })
          .finally(() => {
            state.loading = false;
          });
    };

    const handleCurrentChange = (page) => {
      state.page = page;
      fetchPersonnelData();
    };

    const handleSizeChange = (limit) => {
      state.limit = limit;
      fetchPersonnelData();
    };

    const handleEdit = (row) => {
      state.editForm = {...row};
      state.editDialogVisible = true;
    };

    const saveEdit = () => {
      axios
          .put(`${import.meta.env.VITE_BASE_URL}/studentClass/${state.editForm.id}`, state.editForm, {
            headers: {
              "Content-Type": "application/json",
              token: getToken(),
            },
          })
          .then((response) => {
            const index = state.allTableData.findIndex((item) => item.id === state.editForm.id);
            if (index !== -1) {
              state.allTableData[index] = {...state.editForm};
              ElMessage.success("编辑成功");
            }
          })
          .catch((error) => {
            console.error("Failed to edit personnel:", error);
            ElMessage.error("编辑失败");
          })
          .finally(() => {
            state.editDialogVisible = false;
          });
    };

    const handleDelete = (row) => {
      ElMessageBox.confirm("此操作将永久删除该记录, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
          .then(() => {
            const index = state.allTableData.findIndex((item) => item.id === row.id);
            if (index !== -1) {
              state.allTableData.splice(index, 1);
              state.total = state.allTableData.length;
              ElMessage.success("删除成功");
            }
            deletePersonnel(row.id);
          })
          .catch(() => {
            ElMessage.info("取消删除");
          });
    };

    const deletePersonnel = (id) => {
      axios
          .delete(`${import.meta.env.VITE_BASE_URL}/studentClass/${id}`, {
            headers: {
              token: getToken(),
            },
          })
          .then((response) => {
            console.log(response.data);
          })
          .catch((error) => {
            console.error("Failed to delete personnel:", error);
          });
    };

    const showAddDialog = () => {
      state.addDialogVisible = true;
    };

    const saveAdd = () => {
      const data = {
        className: state.addForm.className,
        counselor: state.addForm.counselor,
      };

      axios
          .post(`${import.meta.env.VITE_BASE_URL}/studentClass`, data, {
            headers: {
              "Content-Type": "application/json",
              token: getToken(),
            },
          })
          .then((response) => {
            state.allTableData.push(response.data);
            state.total = state.allTableData.length;
            ElMessage.success("添加成功");
          })
          .catch((error) => {
            console.error("Failed to add personnel:", error);
            ElMessage.error("添加失败");
          })
          .finally(() => {
            state.addDialogVisible = false;
            state.addForm = {className: "", counselor: ""};
          });
    };

    // 计算过滤后的数据
    const filteredData = computed(() => {
      return state.allTableData.filter((item) =>
          item.className.toLowerCase().includes(state.searchQuery.toLowerCase())
      );
    });

    // 在组件加载时获取数据
    onMounted(() => {
      fetchPersonnelData();
    });

    return {
      ...toRefs(state),
      filteredData,
      fetchPersonnelData,
      handleCurrentChange,
      handleSizeChange,
      handleEdit,
      saveEdit,
      handleDelete,
      showAddDialog,
      saveAdd,
    };
  },
});
</script>

<style scoped>
.personnel-information-table {
  padding: 20px;
}

.pagination-block {
  margin-top: 20px;
}
</style>

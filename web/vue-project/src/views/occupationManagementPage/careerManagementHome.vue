<template>
  <div>
    <el-row :gutter="20">
      <el-col :span="12" :offset="16">
        <el-button type="primary" :icon="Plus" circle @click="showAddDialog" :offset="6"/>
      </el-col>
    </el-row>

    <el-table v-loading="loading" :data="paginatedJobs" style="width: 100%">
      <el-table-column prop="id" label="职业ID" :span="3"></el-table-column>
      <el-table-column prop="name" label="职业名字" :span="2"></el-table-column>
      <el-table-column label="操作" :span="4">
        <template #default="scope">
          <el-button @click="editJob(scope.row)" type="primary" :icon="Edit" circle />
          <el-button @click="deleteJob(scope.row.id)" type="danger" :icon="Delete" circle />
        </template>
      </el-table-column>
    </el-table>

    <el-pagination
        background
        layout="total, prev, pager, next, jumper"
        :total="jobs.length"
        :page-size="pageSize"
        :current-page="currentPage"
        @current-change="handlePageChange">
    </el-pagination>

    <el-dialog title="编辑职业" v-model="dialogVisible">
      <el-form :model="editForm">
        <el-form-item label="职业ID">
          <el-input v-model="editForm.id" disabled></el-input>
        </el-form-item>
        <el-form-item label="职业名字">
          <el-input v-model="editForm.name"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="cancelEdit">取消</el-button>
        <el-button type="primary" @click="saveJob">保存</el-button>
      </div>
    </el-dialog>

    <el-dialog title="添加职业" v-model="addDialogVisible">
      <el-form :model="addForm">
        <el-form-item label="职业名字">
          <el-input v-model="addForm.name"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="cancelAdd">取消</el-button>
        <el-button type="primary" @click="addJob">添加</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { Delete, Edit, Plus } from "@element-plus/icons-vue";
import axios from "axios";
import { getToken } from "@/stores/auth.js";

export default {
  data() {
    return {
      jobs: [],
      dialogVisible: false,
      addDialogVisible: false,
      editForm: {
        id: '',
        name: '',
      },
      addForm: {
        name: '',
      },
      currentPage: 1,
      pageSize: 14,
    };
  },
  computed: {
    Plus() {
      return Plus
    },
    Delete() {
      return Delete;
    },
    Edit() {
      return Edit;
    },
    paginatedJobs() {
      const start = (this.currentPage - 1) * this.pageSize;
      return this.jobs.slice(start, start + this.pageSize);
    },
  },
  methods: {
    savePersonnel(id, name) {
      let data = {
        "id": id,
        "name": name
      };

      axios.put(`${import.meta.env.VITE_BASE_URL}/personnelClass`, data, {
        headers: {
          'Content-Type': 'application/json',
          'token': getToken(),
        }
      })
          .then(response => {
            if (response.data.code === 200) {
              this.$message.success('保存成功');
            } else {
              this.$message.error('保存职业数据失败');
            }
          })
          .catch(error => {
            console.error('Failed to save personnel data:', error);
            this.$message.error('保存职业数据失败');
          })
          .finally(() => {
            this.dialogVisible = false;
          });
    },
    addPersonnel(name) {
      let data = {
        "name": name
      };

      axios.post(`${import.meta.env.VITE_BASE_URL}/personnelClass`, data, {
        headers: {
          'Content-Type': 'application/json',
          'token': getToken(),
        }
      })
          .then(response => {
            if (response.data.code === 200) {
              this.$message.success('添加成功');
              this.jobs.push(response.data.data);
            } else {
              this.$message.error('添加职业数据失败');
            }
          })
          .catch(error => {
            console.error('Failed to add personnel data:', error);
            this.$message.error('添加职业数据失败');
          })
          .finally(() => {
            this.addDialogVisible = false;
          });
    },
    deletePersonnel(id) {
      axios.delete(`${import.meta.env.VITE_BASE_URL}/personnelClass/${id}`, {
        headers: {
          'token': getToken()
        }
      })
          .then((response) => {
            this.$message({
              message: `删除成功，职业ID：${id}`,
              type: 'success'
            });
          })
          .catch((error) => {
            console.log(error);
          });
    },
    fetchJobs() {
      axios.get(`${import.meta.env.VITE_BASE_URL}/personnelClass`, {
        headers: {
          'token': getToken()
        }
      })
          .then(response => {
            if (response.data.code === 200) {
              this.jobs = response.data.data;
            } else {
              this.$message.error('获取职业数据失败');
            }
          })
          .catch(error => {
            console.error('Failed to fetch jobs data:', error);
            this.$message.error('获取职业数据失败');
          });
    },
    deleteJob(id) {
      this.jobs = this.jobs.filter(job => job.id !== id);
      this.deletePersonnel(id);
    },
    editJob(row) {
      this.editForm = { ...row };
      this.dialogVisible = true;
    },
    saveJob() {
      this.savePersonnel(this.editForm.id, this.editForm.name);
      const index = this.jobs.findIndex(job => job.id === this.editForm.id);
      if (index !== -1) {
        this.jobs.splice(index, 1, { ...this.editForm });
      }
      this.dialogVisible = false;
    },
    addJob() {
      console.log('添加的数据:', this.addForm);
      this.addPersonnel(this.addForm.name);
      this.addForm = { name: '' };
    },
    cancelEdit() {
      this.dialogVisible = false;
      this.$message({
        message: '取消编辑',
        type: 'info'
      });
    },
    cancelAdd() {
      this.addDialogVisible = false;
      this.$message({
        message: '取消添加',
        type: 'info'
      });
    },
    showAddDialog() {
      this.addDialogVisible = true;
    },
    handlePageChange(page) {
      this.currentPage = page;
    },
  },
  mounted() {
    this.fetchJobs();
  }
};
</script>

<style scoped>
#vue-devtools-anchor {
  border: #4facfe 1px solid;
}
</style>

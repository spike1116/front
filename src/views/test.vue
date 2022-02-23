<template>
<div style="padding:10px">
    <div style="margin-bottom:10px">
        <el-input style="width:15%" v-model="search" placeholder="请输入学生姓名" clearable></el-input>
        <el-button  type="primary" style="margin-left:10px" @click="load">搜索</el-button>
        <el-button type="primary" @click="add">添加</el-button>
    </div>
    <div>
<el-table
    :data="tableData"
    :default-sort="{ prop: 'date', order: 'descending' }"
    border style="width: 100%"
    
  >
    <el-table-column prop="id" label="学号" sortable  />
    <el-table-column prop="name" label="姓名"  />
    <el-table-column prop="sex" label="性别"  />
    <el-table-column prop="age" label="年龄"  />
    <el-table-column prop="phone" label="电话"  />
    <el-table-column label="操作">
      <template #default="scope">
        <el-button size="small" @click="handleEdit(scope.row)"
          >编辑</el-button
        >

          <el-popconfirm title="是否删除该学生数据？" @confirm="handleDelete(scope.row.id)">
              <template #reference>
                  <el-button
                          size="small"
                          type="danger"
                         >删除</el-button>
              </template>
          </el-popconfirm>

        </template>
        </el-table-column>
        </el-table>

    </div>
    
    <div >
        <el-pagination
                @size-change="handleSizeChange"
                @current-change="handleCurrentChange"
                :current-page="currentPage"
                :page-sizes="[5, 10, 20]"
                :page-size="pageSize"

                layout="total, sizes, prev, pager, next, jumper"
                :total="total"
        >
        </el-pagination>
  </div>



    <el-dialog
    v-model="dialogVisible"
    title=""
    width="30%"
    :before-close="handleClose"
  >
    <el-form  :model="editForm" label-width="80px">

              <el-form-item label="姓名">
                <el-input v-model="editForm.name" />
              </el-form-item>
            <el-form-item label="性别">
                <el-radio v-model="editForm.sex" label="男">男</el-radio>
                <el-radio v-model="editForm.sex" label="女">女</el-radio>
            </el-form-item>
              <el-form-item label="年龄">
                <el-input v-model="editForm.age" />
              </el-form-item>
              <el-form-item label="电话号码">
                <el-input v-model="editForm.phone"  />
              </el-form-item>
            </el-form>
    
    <template #footer>
      <span class="dialog-footer">
        <el-button type="primary" @click="save">确认</el-button>
        <el-button @click="dialogVisible = false">取消</el-button>
       
      </span>
    </template>
  </el-dialog>

   
</div>
       

</template>

<script>
import request from "../utils/request";

export default {
    name:'Test',
    data(){
        return {
            dialogVisible:false,
            currentPage:1,
            pageSize:5,
            total:10,
            editForm: {},
            tableData:[],
            search:''
        }     
    },
        methods:{
            load(){
                request.get("/student",{
                params:{
                    pageNum:this.currentPage,
                    pageSize:this.pageSize,
                    search:this.search
                }


                }).then(res=>{
                    console.log(res);
                    this.tableData=res.data.records;
                    this.total=res.data.total;
                })
            },

            handleSizeChange(pageSize){
                console.log(pageSize)
                this.pageSize=pageSize
                this.load();
            },
            handleCurrentChange(pageNum){
                console.log(pageNum)
                this.currentPage=pageNum;
                this.load();
            },
            handleDelete(id){
                request.delete("/student/"+id).then(res=>{
                    if(res.code==='0'){
                        this.$message({
                            type:"success",
                            message:"删除成功"
                        })
                    }else{
                        this.$message({
                            type:"error",
                            message:res.msg
                        })
                    }
                })
                this.load();
                console.log(id)

            },
            add(){
                this.dialogVisible=true;
                this.editForm = {}
            },
            save(){
                if(this.editForm.id!=null){
                    request.put("/student",this.editForm).then(res =>{
                        console.log(res)
                        if(res.code==='0'){
                            this.$message({
                                type:"success",
                                message:"更新成功"
                            })
                        }else{
                            this.$message({
                                type:"error",
                                message:res.msg
                            })
                        }
                        this.load();
                        this.dialogVisible=false;
                    })
                }else{
                    request.post("/student",this.editForm).then(res =>{
                        console.log(res.code)
                        if(res.code==='0'){
                            this.$message({
                                type:"success",
                                message:"新增成功"
                            })
                        }else{
                            this.$message({
                                type:"error",
                                message:res.msg
                            })
                        }
                        this.load();
                        this.dialogVisible=false;
                    })
                }

            },
            find(){
                this.load();
            },
            handleEdit(row){
                console.log(row);
                this.dialogVisible=true;
                this.editForm=JSON.parse(JSON.stringify(row))
            }

    },
    created(){
        this.load();
    }
    // // mounted(){
    // //     request.get("/student").then(res=>{
    // //         this.tableData=res;
    // //     })
    // }

}
</script>

<style>

</style>
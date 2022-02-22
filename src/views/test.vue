<template>
<div style="padding:10px">
    <div style="margin-bottom:10px">
        <el-input style="width:15%"></el-input>
        <el-button  type="primary" style="margin-left:10px" @click="centerDialogVisible=true">搜索</el-button>
        <el-button type="primary" @click="add()">添加</el-button>
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
        <el-button size="small" @click="handleEdit(scope.$index, scope.row)"
          >编辑</el-button
        >
        <el-button
          size="small"
          type="danger"
          @click="handleDelete(scope.$index, scope.row)"
          >删除</el-button
        >
        </template>
        </el-table-column>
        </el-table>

    </div>
    
    <div class="demo-pagination-block">
    <el-pagination
      v-model:currentPage="currentPage4"
      v-model:page-size="pageSize4"
      :page-sizes="[5,10,20]"
      :page-size="10"
      :small="small"
      :disabled="disabled"
      :background="background"
      layout="total, sizes, prev, pager, next, jumper"
      :total="total"
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
    >
    </el-pagination>
  </div>



    <el-dialog
    v-model="dialogVisible"
    title=""
    width="30%"
    :before-close="handleClose"
  >
    <el-form ref="editForm" :model="editForm" label-width="80px">
              <el-form-item label="学号" prop="name">
                <el-input v-model="editForm.id" auto-complete="off" />
              </el-form-item>
              <el-form-item label="姓名">
                <el-input v-model="editForm.name" />
              </el-form-item>
              <el-form-item label="性别">
                <el-input v-model="editForm.sex" />
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
        <el-button type="primary" @click="dialogVisible = false">确认</el-button>
        <el-button @click="dialogVisible = false">取消</el-button>
       
      </span>
    </template>
  </el-dialog>

   
</div>
       

</template>

<script>
export default {
    name:'Test',
    data(){
        return {
            dialogVisible:false,
            currentPage:1,
            total:7,
            editForm:{
               
            },
            tableData:[{id:20011825,name:"王晓鹏",sex:"男",age:22,phone:"15874598752"},
            {id:20011824,name:"李云",sex:"男",age:21,phone:"15874598752"},
            {id:20011823,name:"刘萌",sex:"男",age:22,phone:"15874598752"},
            {id:20011822,name:"吴鹏飞",sex:"男",age:22,phone:"15874598752"},
            {id:20011820,name:"胡中伟",sex:"男",age:22,phone:"15874598752"},
            {id:20011821,name:"李辉",sex:"男",age:22,phone:"15874598752"},
            {id:20011819,name:"陈宏远",sex:"男",age:22,phone:"15874598752"},
            ]
        }     
    },
        methods:{
            handleDelete(index,row){
                
                console.log(row.id)
                console.log(index)
            },
            add(){
           
            },
            handleEdit(index,row){
                console.log(row);
                this.dialogVisible=true;
                this.editForm=JSON.parse(JSON.stringify(row))
            },
            handleSizechange(){

            },
            handleCurrentChange(){

            }

    }

}
</script>

<style>

</style>
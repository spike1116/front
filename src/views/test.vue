<template>
<div>
    <div style="height: 5%;border-bottom:1px solid #ccc;margin:10px;">
        <el-input style="width:10%"></el-input>
        <el-button  style="margin-left:10px">搜索</el-button>
        <el-button>添加</el-button>
    </div>
    <div>
<el-table :data="tableData" stripe style="width: 100%">
    <el-table-column prop="date" label="Date"  />
    <el-table-column prop="name" label="Name"  />
    <el-table-column prop="address" label="Address" />
  </el-table> 
    </div>

</div>
       

</template>

<script>
export default {
    name:'Test',
    data(){
        return {
            tableData:[{date:2001,name:"spike",address:"Test"},
            {date:2001,name:"spike",address:"Test"},
            {date:2001,name:"spike",address:"Test"},
            {date:2001,name:"spike",address:"Test"},
            {date:2001,name:"spike",address:"Test"},

            
            
            ]
        }
       
    }

}
</script>

<style>

</style>
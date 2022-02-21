<template>
       <el-table :data="tableData" stripe style="width: 100%">
    <el-table-column prop="date" label="Date"  />
    <el-table-column prop="name" label="Name"  />
    <el-table-column prop="address" label="Address" />
  </el-table> 

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
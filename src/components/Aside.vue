<template>
    <el-col span="12" >
      <el-menu
        style="width:200px;min-height:calc(100vh - 50px)"
        default-active="test"
        router
        class="el-menu-vertical-demo"
      >
        <el-sub-menu index="1">
          <template #title>
            <el-icon><location /></el-icon>
            <span>菜单一</span>
          </template>
          <el-menu-item-group >
            <el-menu-item index="test">选项一</el-menu-item>
            <el-menu-item index="/">选项二</el-menu-item>
          </el-menu-item-group>
     
        </el-sub-menu>

      </el-menu>
    </el-col>
</template>

<script>
import { Location } from "@element-plus/icons"

export default {
 
 name:'Aside',
 components:{
   Location
 }
}
</script>

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
            <el-menu-item index="test">
              <el-icon><Menu /></el-icon>
            <span>选项一</span>
            </el-menu-item>
            <el-menu-item index="/">
             <el-icon><List /></el-icon>
            <span>选项二</span>
            </el-menu-item>
          </el-menu-item-group>
     
        </el-sub-menu>

      </el-menu>
    </el-col>
</template>

<script>
import { Location,Menu} from "@element-plus/icons"

export default {
 
 name:'Aside',
 components:{
   Location,Menu
 }
}
</script>

<template>
  <div id="nav">
    <Header></Header>

    <div style="display:flex">
      <!-- <Aside /> -->
      <Aside></Aside>
      <router-view style="flex:1" />

    </div>
  </div>

</template>

<script>
import Header from "@/components/Header";
import Aside from "@/components/Aside"
export default{
  name:"Layout",
  components:{
    Header,
    Aside
  }
}
</script>
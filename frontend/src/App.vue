<template>
  <div id="app">
    <NavigationBar/>
  </div>
  <div class="app-body">
    <router-view></router-view>
  </div>

</template>

<script>

import NavigationBar from "@/components/navigation/NavigationBar.vue";



export default {
  name: 'App',
  components: {
    NavigationBar
  }
}
</script>

<style>
body{
  margin: 0;
}
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>

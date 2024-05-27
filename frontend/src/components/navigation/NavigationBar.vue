
<template>
  <div class="nav-bar-container">
    <div  class="logo-container">
      <p>Yachts</p>
    </div>
    <div class="nav-components">
      <router-link to="/" class="nav-component">Home</router-link>
      <p class="about-component">About</p>
    </div>
    <div class="profile-container">
      <p>Profile</p>
    </div>
  </div>
</template>
<script setup>

</script>

<style scoped>
.nav-bar-container {
  position: fixed;
  top: 0;
  width: 100%;
  height: 10%;
  background-color: #A0D3F2;
  display: flex;
  justify-content: space-between;
  align-items: center;
}
.logo-container {
  margin-left: 2vw;
}
.nav-components {
  flex: 1;
  display: flex;
  justify-content: flex-end;
  gap: 2vw;
  margin-right: 4vw;
}
.nav-component {
  margin-top: auto;
  margin-bottom: auto;
  text-decoration: none;
}
.profile-container{
  margin-right: 2vw;
}


</style>
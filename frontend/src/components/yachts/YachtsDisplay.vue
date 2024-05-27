<template>
  <div class="yachts-display-container">
    <div class="title-container">
      <h1>Book a yacht today</h1>
    </div>
    <div class="yacht-list-container">
      <p>{{error}}</p>
      <ul class="yacht-list">
        <li class="yacht-list-item" v-for="yacht in yachts" :key="yacht.yachtId">
          <div class="yacht-list-item-container">
            <div class="yacht-name-container">
              <h2>{{yacht.name}}</h2>
            </div>
            <hr>
            <div class="yacht-details-container">
              <p>This is an {{yacht.type}} yacht.</p>
              <div class="yacht-cost">
                <p>Book this yacht for: {{yacht.pricePerDay}} per day.</p>
              </div>
            </div>
            <div class="book-yacht-container">
              <router-link :to="'/book_yacht/'+yacht.yachtId">Book this yacht</router-link>
            </div>
          </div>
        </li>
      </ul>
    </div>
  </div>
</template>
<script>
  import YachtsManager from "@/components/yachts/YachtsManager"
  export default {
    name: "YachtsDisplay",
    mixins: [YachtsManager]
  }

</script>
<style scoped>
.yachts-display-container{
  margin-top: 15vh;
}
.yacht-list-container {
  margin: 0 auto;
  width: 70%;
}
.yacht-list-item-container{
  margin-bottom: 4vh;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  height: 50vh;
  background-color: #A0D3F2;
}
.yacht-list{
  padding: 0;
  list-style: none;
}
.book-yacht-container{
  margin: 5vh auto;
  align-self: flex-end;
}
</style>
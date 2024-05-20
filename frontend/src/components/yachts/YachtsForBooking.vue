<template>
  <div class="component-container">
    <h1>Yachts for booking</h1>
    <ul class="list-container">
      <li v-for="yacht in yachts" :key="yacht.yachtId" class="list-item">
        <div>
          <h2>
            {{ yacht.name }}
          </h2>
          <hr>
          <p>
          yacht type: {{ yacht.type }}
          </p>
          <p>
          cost per day: {{ yacht.pricePerDay }}
          </p>
          <hr>
          <button @click="handleRentButtonClick(yacht)">Rent</button>
        </div>
      </li>
    </ul>
    <CreateBooking v-if="selectedYacht" :yacht="selectedYacht" @confirmBooking="handleBookingConfirmed" @cancelBooking="handleBookingCancelled"/>
  </div>
</template>

<script>
import YachtsForBooking from "@/components/yachts/YachtsForBooking.js";
export default {
  name: 'YachtsForBooking',
  mixins:[YachtsForBooking]
}


</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.component-container{
  margin: 0 auto;
  width: 80vw;
}
.list-container {
  display: grid;
  grid-template-columns:repeat(auto-fill, minmax(20vw, 1fr));
  grid-gap: 1vw;
  list-style-type: none;
  padding: 0;
  justify-content: center;
}

.list-item {
  text-align: center;
  padding: 10px;
  background-color: lightgray;
}
</style>

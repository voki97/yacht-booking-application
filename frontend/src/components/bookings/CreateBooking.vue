<template>
  <div class="booking-container">
    <div class="booking-content">
      <h2>Rent {{ yacht.name }}</h2>
      <hr>
      <p>
        yacht type: {{ yacht.type }}
      </p>
      <p>
        cost per day: {{ yacht.pricePerDay }}
      </p>
      <hr>
      <div class="date-picker-container">
        <div class="start-date-picker">
          <label for="start-date-picker-input">Start date:</label>
          <input type="date" id="start-date-picker-input" v-model="startDate" @change="calculateTotalPrice"
                 :min="minStartDate" :max="maxStartDate" required>
        </div>
        <div class="end-date-picker">
          <label for="end-date-picker-input">End date:</label>
          <input type="date" id="end-date-picker-input" v-model="endDate" @change="calculateTotalPrice"
                 :min="minEndDate"
                 required>
        </div>
      </div>
      <hr>
      <div class="total-price-container">
        <p>Total price: {{ totalPrice }}</p>
      </div>
      <button @click="confirmBooking">Confirm Booking</button>
      <button @click="cancelBooking">Cancel</button>
    </div>
  </div>
</template>

<script>
import CreateBooking from "@/components/bookings/CreateBooking.js"
export default {
  name: "CreateBooking",
  mixins: [CreateBooking]
}
</script>

<style scoped>
.booking-container{
  display: flex;
  justify-content: center;
}
.booking-content {
  position: absolute;
  width: 60vw;
  padding: 1vw;
  background-color: darkgray;
}
</style>
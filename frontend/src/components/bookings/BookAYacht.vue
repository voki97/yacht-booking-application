<template>
  <div class="yacht-details-container">
    <YachtDetails :yacht-id="yachtId" @sendYachtToBooking="getYacht($event)"/>
  </div>
  <div class="date-pick-container">
    <DatePicker @sendDateToBooking="getDate($event)"/>
  </div>
  <ApplyDiscount @sendDiscount="getDiscount($event)"/>
  <div class="price-container">
    {{error}}
    <div class="price-with-discount" v-if="discountId">
      <p>Total after discount: {{totalPrice}}</p>
      <button @click="confirmBooking">Confirm</button>
    </div>
    <div class="price-without-discount"
    v-else>
      <p>Total: {{totalPrice}}</p>
      <button v-if="totalPrice>0"
              @click="confirmBooking">Confirm</button>
    </div>

  </div>
</template>
<script>
import BookingManager from "@/components/bookings/BookingManager";
import YachtDetails from "@/components/yachts/YachtDetails.vue";
import DatePicker from "@/components/datePicker/DatePicker.vue";
import ApplyDiscount from "@/components/discounts/ApplyDiscount.vue";

export default {
  name: 'BookAYacht',
  components: {ApplyDiscount, DatePicker, YachtDetails},
  mixins:[BookingManager]
}
</script>
<style scoped>
.yacht-details-container{
  margin-top: 20vh;
}
</style>
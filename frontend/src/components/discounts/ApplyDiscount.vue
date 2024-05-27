<template>
  <div class="discount-container">
    <div class="discount-input-container" v-if="discount===null">
      <h2>Apply discount</h2>
      <label for="discount_input">Discount code:</label>
      <input id="discount_input"
             type="text"
             v-model="discountCode"/>
      <button @click="getDiscountByCode(discountCode)">Apply discount</button>
      <p>{{error}}</p>
    </div>
    <div class="discount-details-container"
         v-else>
      <h2>Applied discount:</h2>
      <p>{{discount.type}}</p>
      <p>{{discount.value}}% off</p>
      <p v-if="discount.startDate!==null">This discount is valid from {{discount.startDate}} to {{discount.endDate}}!</p>
      <p v-else>This discount is always available.</p>
    </div>
  </div>
</template>

<script>
import DiscountManager from "@/components/discounts/DiscountManager";

export default {
  name: "ApplyDiscount",
  mixins: [DiscountManager]
}
</script>

<style scoped>

</style>
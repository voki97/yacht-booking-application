
<template>
  <div class="yacht-details-container">
    <p>{{error}}</p>
    <div class="yacht-details-header">
      <h1>{{yacht.name}}</h1>
    </div>
    <div class="yacht-details-body">
      <p>Type: {{yacht.type}}</p>
      <p>Price per day: {{yacht.pricePerDay}}</p>
    </div>
  </div>
</template>
<script>
import YachtsManager from "@/components/yachts/YachtsManager";

export default {
  name: 'YachtDetails',
  mixins:[YachtsManager]
}
</script>

<style scoped>
.yacht-details-container{
  margin-top: 20vh;
}
</style>
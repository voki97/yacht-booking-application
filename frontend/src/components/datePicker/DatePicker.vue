<template>
  <div class="date-picker-container">
    <div class="start-date-picker">
      <label for="start-date-input">Start date:</label>
      <input id="start-date-input"
             type="date"
             v-model="startDate"
             v-if="!dateIsPicked"
             :min="minStartDate"
             :max="maxStartDate"
             @change="sendDateToBooking"/>
      <p v-if="dateIsPicked">{{startDate}}</p>
    </div>
    <div class="end-date-picker">
      <label for="end-date-input">End date:</label>
      <input id="end-date-input"
             type="date"
             v-model="endDate"
             v-if="!dateIsPicked"
             :min="minEndDate"
             @change="sendDateToBooking"/>
      <p v-if="dateIsPicked">{{endDate}}</p>
    </div>
  </div>
</template>
<script>
import DatePickerManager from "@/components/datePicker/DatePickerManager";

export default {
  name: "DatePicker",
  mixins: [DatePickerManager]
}
</script>

<style scoped>

</style>
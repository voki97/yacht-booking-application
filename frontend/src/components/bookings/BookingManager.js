import YachtDetails from "@/components/yachts/YachtDetails.vue";
import Yacht from "@/models/Yacht";
import bookingService from "@/components/bookings/BookingService";

export default {
    name: 'BookingManager',
    props: {
        yachtId: {
            type: String,
            required: true
        }
    },
    data() {
        return {
            yacht: new Yacht,
            startDate: null,
            endDate: null,
            discountId:null,
            totalPrice: 0,
            error: null
        }
    },
    components: {
        YachtDetails
    },
    watch:{
      endDate: 'calculateTotalPrice'
    },
    methods: {
        getYacht(yacht) {
            this.yacht = yacht
        },
        getDate(selectedDate) {
            this.startDate = selectedDate.startDate
            this.endDate = selectedDate.endDate
        },
        getDiscount(discountId) {
            this.discountId = discountId
            this.calculateTotalPrice().catch(error => {
                this.error = error
            })
        },
        async calculateTotalPrice() {
            try{
                if(this.startDate!==null && this.endDate!==null && this.yacht.pricePerDay!==null && this.discountId!==null){
                    this.totalPrice = await bookingService.calculateTotalPrice(
                        this.startDate,
                        this.endDate,
                        this.yacht.pricePerDay,
                        this.discountId
                    )
                }
                else if(this.startDate!==null && this.endDate!==null && this.yacht.pricePerDay!==null){
                    this.totalPrice = await bookingService.calculateTotalPrice(
                        this.startDate,
                        this.endDate,
                        this.yacht.pricePerDay
                    )
                }
            }catch(error){
                this.error = error.message
            }
        },
        async confirmBooking(){
          try{
              if(this.totalPrice>0){
                  await bookingService.saveBooking(
                      this.yacht,
                      this.startDate,
                      this.endDate,
                      this.totalPrice,
                      'pending',
                      this.discountId
                  )
              }
          }catch (error){
              this.error = error.message
          }
        }
    }
}
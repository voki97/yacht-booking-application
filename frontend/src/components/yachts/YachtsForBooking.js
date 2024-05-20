import Yacht from "@/models/Yacht";
import CreateBooking from "@/components/bookings/CreateBooking.vue";

export default {
    name: 'YachtsForBooking',
    components: {
        CreateBooking
    },
    data() {
        return {
            yachts: [],
            selectedYacht: null
        }
    },
    created() {
        this.fetchYachts().catch(error=>{
            console.error('Error in created hook: ', error);
        })
    },
    methods: {
        async fetchYachts() {
            try {
                const response = await fetch('http://localhost:8080/api/yacht/all')
                if (!response.ok) {
                    new Error('Network response is not okay!')
                }
                const yachtsData = await response.json();
                this.yachts = yachtsData.map(yachtData => new Yacht(
                    yachtData.yachtId,
                    yachtData.name,
                    yachtData.type,
                    yachtData.pricePerDay
                ));
            } catch (error) {
                console.error('Error fetching Yachts for booking, reason: ' + error)
            }
        },
        handleRentButtonClick(yacht) {
            if(this.selectedYacht==null){
                this.selectedYacht = yacht;
            }else{
                this.selectedYacht=null
            }

        },
        handleBookingConfirmed() {
            this.selectedYacht = null;
        },
        handleBookingCancelled() {
            this.selectedYacht = null;
        }
    }
}
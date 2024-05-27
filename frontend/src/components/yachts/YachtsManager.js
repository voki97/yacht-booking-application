import yachtService from "@/components/yachts/YachtService";
import Yacht from "@/models/Yacht";

export default {
    name: 'YachtsManager',
    props: {
      yachtId: {
          type: String
      }
    },
    data() {
        return {
            yachts: [],
            yacht: new Yacht,
            error: null,
        }
    },
    created() {
        this.fetchYachts().catch(error => {
            console.error('Error in created hook: ', error);
        })
        this.getYacht(this.yachtId).catch(error => {
            console.error('Error: ', error)
        })
    },
    methods: {
        async fetchYachts() {
            try {
                this.yachts = await yachtService.getAll()
            } catch (error) {
                this.error = error.message
            }
        },
        async getYacht(id) {
            if(id!==undefined){
                try {
                    this.yacht = await yachtService.getById(id)
                    this.sendYachtToBooking(this.yacht)
                } catch (error) {
                    this.error = error.message
                }
            }
        },
        sendYachtToBooking(yacht){
            this.$emit('sendYachtToBooking', yacht)
        }
    }
}
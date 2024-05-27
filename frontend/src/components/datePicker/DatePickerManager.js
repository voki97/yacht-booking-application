export default{
    name:"DatePickerManager",
    data(){
        return{
            startDate: null,
            endDate: null,
            dateIsPicked: false
        }
    },
    methods:{
    sendDateToBooking(){
        if(this.startDate&&this.endDate){
            this.dateIsPicked = true
            this.$emit('sendDateToBooking', {
                startDate: this.startDate,
                endDate: this.endDate,
            })
        }
    }
    },
    computed:{
        minStartDate(){
            return new Date().toISOString().split('T')[0]
        },
        minEndDate(){
            if(!this.startDate) return null
            const start = new Date(this.startDate)
            const end = new Date(start.getTime() + (24 * 60 * 60 * 1000))
            return end.toISOString().split('T')[0]
        },
        maxStartDate(){
            if (!this.endDate) return null
            const end = new Date(this.endDate)
            const start = new Date(end.getTime() - (24 * 60 * 60 * 1000))
            return start.toISOString().split('T')[0]
        }
    }
}
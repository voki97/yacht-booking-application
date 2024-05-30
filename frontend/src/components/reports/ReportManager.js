import reportService from "@/components/reports/ReportService.js";

export default {
    name: 'ReportManager',
    props:[
        'bookingId'
    ],
    data(){
        return{
            error: null
        }
    },
    created() {
        this.createNewReport(this.bookingId).catch(error=>{
            this.error = error.message
        })
    },
    methods:{
        async createNewReport(bookingId){
            try{
                 await reportService.createReport(bookingId);
            }
            catch(error){
                this.error = error.message;
            }
        }
    }
}
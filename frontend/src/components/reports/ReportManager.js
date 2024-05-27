import reportService from "@/components/reports/ReportService.js";

export default {
    name: 'ReportManager',
    data(){
        return{
            error: null
        }
    },
    methods:{
        async createNewReport(reportData){
            try{
                 const newReport = await reportService.createReport(reportData);
                console.log(newReport)
            }
            catch(error){
                this.error = error.message;
            }
        }
    }
}
import {CREATE_REPORT_ENDPOINT} from '@/config.js'
class ReportService{
//Create new record in the database:
     async createReport(reportData){
    const response = await fetch(CREATE_REPORT_ENDPOINT, {
        method: 'POST',
        headers:{
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(reportData),
    })
        if (!response.ok) {
            throw new Error('Report is not created!')
        }
        else
        {
            console.log('Report successfully created!')
            return response.json()
        }
    }
}
export default new ReportService;
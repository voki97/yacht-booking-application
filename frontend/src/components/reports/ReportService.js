import {CREATE_REPORT_ENDPOINT} from '@/config.js'

class ReportService {
//Create new record in the database:
    async createReport(bookingId) {
        console.log(bookingId)
        const response = await fetch(CREATE_REPORT_ENDPOINT, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                bookingId: bookingId
            })
        })
        if (!response.ok) {
            throw new Error('Report is not created!')
        } else {
            console.log('Report successfully created!')
            return response.json()
        }
    }
}

export default new ReportService;
export const HOST_URL = 'http://localhost:8080'

//Yacht API PATHS:
export const YACHT_BASE_URL = '/api/yacht'
export const GET_ALL_YACHTS_ENDPOINT = `${HOST_URL}${YACHT_BASE_URL}/all`
export const GET_BY_ID_YACHT_ENDPOINT = `${HOST_URL}${YACHT_BASE_URL}/:id`
//Booking API PATHS:
export const BOOKING_BASE_URL = '/api/booking'
export const CREATE_BOOKING_ENDPOINT = `${HOST_URL}${BOOKING_BASE_URL}/create`
export const BOOKING_CALCULATE_TOTAL_PRICE_ENDPOINT = `${HOST_URL}${BOOKING_BASE_URL}/total_price`
//Discount API PATHS:
export const DISCOUNT_BASE_URL = '/api/discount'
export const DISCOUNT_GET_BY_CODE_ENDPOINT = `${HOST_URL}${DISCOUNT_BASE_URL}/code/:code`
//Report API PATHS:
export const REPORT_BASE_URL = '/api/report'
export const CREATE_REPORT_ENDPOINT = `${HOST_URL}${REPORT_BASE_URL}/create`

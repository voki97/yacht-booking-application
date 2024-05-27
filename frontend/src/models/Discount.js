export default class Discount{
    constructor(discountId, code, type, value, startDate, endDate) {
        this.discountId = discountId;
        this.code = code
        this.type = type
        this.value = value
        this.startDate = startDate
        this.endDate = endDate
    }
}
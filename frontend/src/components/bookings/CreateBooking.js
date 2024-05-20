import Yacht from "@/models/Yacht";

export default {
name: 'CreateBooking',
    props: {
    yacht: {
        type: Yacht,
            required: true
    }
},
data() {
    return {
        startDate: null,
        endDate: null,
        totalPrice: null
    }
},
methods: {
    calculateTotalPrice() {
        if (this.startDate && this.endDate) {
            const start = new Date(this.startDate)
            const end = new Date(this.endDate)
            const duration = Math.ceil((end - start) / (1000 * 60 * 60 * 24));
            this.totalPrice = duration * this.yacht.pricePerDay;
        }
    },
    async confirmBooking() {
        if (!this.startDate || !this.endDate) {
            alert("Start and end dates are required!")
            return
        }
        try {
            const response = await fetch('http://localhost:8080/api/booking/create', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({
                    yacht: this.yacht,
                    startDate: this.startDate,
                    endDate: this.endDate,
                    totalPrice: this.totalPrice,
                    status: 'pending'
                })
            })
            if (!response.ok) {
                new Error('Failed to create booking.')
            }
            alert('Booking successfully created!')
            this.$emit('confirmBooking');
        } catch (error) {
            console.error('Error occurred while creating Booking, reason: ' + error)
        }
    },
    cancelBooking() {
        this.$emit('cancelBooking');
    }
},
computed: {
    minStartDate() {
        return new Date().toISOString().split('T')[0]
    },
    maxStartDate() {
        if (!this.endDate) return null
        const end = new Date(this.endDate)
        const start = new Date(end.getTime() - (24 * 60 * 60 * 1000))
        return start.toISOString().split('T')[0]
    },
    minEndDate() {
        if (!this.startDate) return null
        const start = new Date(this.startDate)
        const end = new Date(start.getTime() + (24 * 60 * 60 * 1000))
        return end.toISOString().split('T')[0]
    }
}
}

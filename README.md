<<<<<<< HEAD
        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }
        
        public Criteria andHotelnameLikeOrHotelformerlynameLike(String value){
            addCriterion("hotelName like", value, "hotelname");
             addCriterion("hotelFormerlyName like", value, "hotelformerlyname");
             return (Criteria) this;
        }
=======
# Hotel Booking

Hello World!
>>>>>>> 41115843e19d2ef4aa75a910e3a57f77dd1c292e

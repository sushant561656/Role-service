package com.register.registerrol.models;

	    public class JwtRespons {
	        private String jwtToken;
	        private String userName;

	        // Private constructor that takes a builder
	        private JwtRespons(Builder builder) {
	            this.jwtToken = builder.jwtToken;
	            this.userName = builder.userName;
	        }

	        // Getter methods for jwtToken and userName

	        public String getJwtToken() {
	            return jwtToken;
	        }

	        public String getUserName() {
	            return userName;
	        }

	        public static Builder builder() {
	            return new Builder();
	        }

	        public static class Builder {
	            private String jwtToken;
	            private String userName;

	            public Builder jwtToken(String jwtToken) {
	                this.jwtToken = jwtToken;
	                return this; // Return the builder to allow method chaining
	            }

	            public Builder username(String userName) {
	                this.userName = userName;
	                return this; // Return the builder to allow method chaining
	            }

	            public JwtRespons build() {
	                return new JwtRespons(this); // Create a JwtRespons instance with the builder's values
	            }
	        }
	    }


	   
	   

	
	


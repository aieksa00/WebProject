Vue.component("register", { 
	data: function () {
	    return {
          users: null,
          date: null,
          user: {username:null, password:null, name:null, surname:null, gender:null, birthDate:null, userType:'Customer'},
          errorMessage:null
	    }
	},
	    template: ` 
        <div>
            <div class="container">
            <form id="forma">
                <span class="text-center">Unesite svoje podatke</span>
                <div class="input-container">		
                    <input type="text" v-model = "user.name" name="name" required="">
                    <label>Ime</label>
                </div>
                <div class="input-container">		
                    <input type="text" v-model = "user.surname" name="surname" required="">
                    <label>Prezime</label>
                </div>
                <div class="input-container">		
                    <input type="text" v-model = "user.gender" name="gender" required="">
                    <label>Pol</label>
                </div>
                <div class="input-container">		
                    <input type="text" onfocus="(this.type='date')" onblur="(this.type='text')" v-model = "date" name="date" required="">
                    <label>Datum rođenja</label>
                </div>
                <div class="input-container">		
                    <input type="text" v-model = "user.username" name="username" required="">
                    <label>Korisničko ime</label>
                </div>
                <div class="input-container">		
                    <input type="password" v-model = "user.password" name="password" required="">
                    <label>Lozinka</label>
                </div>
                <p style="color:red; font-size:20px;">{{errorMessage}}</p>
            </form>
            </div>
            <div class="container">  
            <button class="button-40" v-on:click = "register">Registruj se!</button>  
            </div>
    	</div>			  
    	`,
    mounted () {
        axios
          .get('rest/users/')
          .then(response => (this.users = response.data))       
    },
    methods: {
    	register : function() {
            event.preventDefault();  
            let b = false;          
            this.users.forEach(user => {                
                if(user.username==this.user.username){
                    b=true;
                }              
            });
            if(!b && this.user.username!=null && this.user.password!=null && this.user.name!=null && this.user.surname!=null && this.user.gender!=null && this.date!=null
                  && this.user.username!="" && this.user.password!="" && this.user.name!="" && this.user.surname!="" && this.user.gender!="" && this.date!="")
            {
                axios.post('rest/users/add/'+this.date, this.user).then(router.push(`/users/`))
            }
            else if(b){
                this.errorMessage = 'Korisnik sa ovim imenom već postoji!';
            }
            else{
                this.errorMessage = 'Popunite sva polja!';
            }   		
    	}
    }
});
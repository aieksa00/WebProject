Vue.component("login", { 
	data: function () {
	    return {
	      username: null,
          password: null,
          users: null,
          errorMessage: null,
	    }
	},
	    template: ` 
    	<div>
            <div class="container">
            <form id="forma">
                <span class="text-center">Dobrodošli</span>
                <div class="input-container">		
                    <input type="text" v-model = "username" name="username" required="true">
                    <label>Korisničko ime</label>
                </div>
                <div class="input-container">		
                    <input type="password" v-model = "password" name="password" required="true">
                    <label>Lozinka</label>
                </div>
                <p style="color:red; font-size:16px;">{{errorMessage}}</p>
            </form>
            </div>
            <div class="container">
            <button class="button-40" v-on:click = "login">&nbsp&nbspUloguj se!&nbsp&nbsp</button>
            </div>
            <div class="container">  
            <button class="button-40" v-on:click = "register">Registruj se?</button>  
            </div>
    	</div>	
    	`,
    mounted () {
        axios
          .get('rest/users/')
          .then(response => (this.users = response.data))       
    },
    methods: {
    	login : function() { 
            event.preventDefault();  
            let b = false;          
            this.users.forEach(user => {                
                if(user.username==this.username && user.password==this.password){
                    b=true;
                    router.push(`/users/`);
                }              
            });
            if(!b)
                this.errorMessage = 'Pogrešno korisničko ime ili lozinka';
    		
    	},
        register : function(){
            router.push(`/register/`);
        }    	
    }
});
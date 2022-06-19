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
    	<div class="container">
            <div>
            <form id="forma">
                <table>
                    <tr><td>Korisničko ime:</td><td><input type="text" v-model = "username" name="username"></td></tr>
                    <tr><td>Lozinka:</td><td><input type="password" v-model = "password" name="password"></td></tr>
                    <tr><td colspan='2'>{{errorMessage}}</td></tr>
                </table>
            </form>
            </div>
            <div>
            <button v-on:click = "login">Uloguj se!</button>
            </div>
            <div>  
            <button v-on:click = "register">Registruj se?</button>  
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
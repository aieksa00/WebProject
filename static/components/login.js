Vue.component("login", { 
	data: function () {
	    return {
	      username: null,
          password: null,
          users: null
	    }
	},
	    template: ` 
    	<div>
            <form id="forma">
                <table>
                    <tr><td>Username</td><td><input type="text" v-model = "username" name="username"></td></tr>
                    <tr><td>Password</td><td><input type="password" v-model = "password" name="password"></td></tr>
                    <tr><td><input type = "submit" v-on:click="login" value = "Login"></td></tr>
                </table>
            </form>
            <button v-on:click = "register">Register</button>
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
                console.log('Wrong username or password');
    		
    	},
        register : function(){
            router.push(`/register/`);
        }    	
    }
});
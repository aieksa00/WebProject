Vue.component("sportsobjects", { 
	data: function () {
	    return {
	      objects: null,
		  searchInput : null,
		  searchParam : null,
	    }
	},
	    template: ` 
    	<div>
    		<h2>Prikaz sportskih objekata</h2>
			<div style="display: flex; justify-content: flex-end">
				<select name="searchParams" id="searchParams" v-model = "searchParam">
					<option value="objectType">Tip Objekta</option>
					<option value="name">Naziv</option>
					<option value="location">Lokacija</option>
					<option value="rating">Ocena</option>
				</select>
				<input type="text" v-model = "searchInput" name="searchInput">
				<button v-on:click = "search">Pretraži</button>
			</div>
			</br>
            <table border="1">
	    		<tr bgcolor="lightgrey">
	    			<th>Naziv</th>
	    			<th>Tip Objekta</th>
                    <th>Opis</th>
	    			<th>Status</th>
					<th>Lokacija</th>
					<th>Ocena</th>
					<th>Radno Vreme</th>
					<th>Slika</th>
	    		</tr>	    			
	    		<tr v-for="(o, index) in objects">
	    			<td>{{o.name}}</td>
	    			<td>{{o.objectType}}</td>
                    <td>{{o.description}}</td>
                    <td v-if="o.status">Open</td>
					<td v-else>Closed</td>
					<td>({{o.location.geoLength}}, {{o.location.geoWidth}}) {{o.location.address.street}}
					{{o.location.address.number}}, {{o.location.address.city}}, {{o.location.address.postCode}}
					</td>
					<td>{{o.rating}}</td>
					<td>{{o.workingHours}}</td>
					<td><img :src="o.image" alt="Slika objekta"></td>
	    		</tr>
	    	</table>
    	</div>		  
    	`,
    mounted () {
        axios
          .get('rest/sportsobjects/')
          .then(response => (this.objects = response.data))
    },
    methods: {
    	search : function(){
			if(this.searchInput!=null && this.searchInput!=""){
				axios
					.get('rest/sportsobjects/' + this.searchParam +"/"+ this.searchInput)
					.then(response => (this.objects = response.data))
			}
			else{
				axios
					.get('rest/sportsobjects/')
					.then(response => (this.objects = response.data))
			}
        }  
    }
});
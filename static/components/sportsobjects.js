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
			<div class="container"><h1>Prikaz sportskih objekata</h1></div>
			<div class="container">
				<select name="searchParams" id="searchParams" v-model = "searchParam" style="margin:0 30px 25px 0; font-size:20px">
					<option value="objectType">Tip Objekta</option>
					<option value="name">Naziv</option>
					<option value="location">Lokacija</option>
					<option value="rating">Ocena</option>
				</select>
				<div class="input-container">		
					<input type="text" v-model = "searchInput" name="searchInput" required="">
                    <label>Pretraga</label>
                </div>
				<button v-on:click = "search" class="button-40" style="margin:0 0 25px 30px">Pretraži</button>
			</div>
			<div v-for="(o, index) in objects">
				<div class="container">
					<h1>{{o.name}}</h1>
				</div>
				<div class="container">
					<img :src="o.image" alt="Slika objekta" style="
						max-width: 100%;
						height: auto;">
				</div>		
				<div class="container">
					<p v-if="o.status" style="font-size:25px">Opis: {{o.description}}. Objekat je otvoren.<br>
					Tip objekta: {{o.objectType}}<br>
					Lokacija: ({{o.location.geoLength}}, {{o.location.geoWidth}}) {{o.location.address.street}} {{o.location.address.number}}, {{o.location.address.city}}, {{o.location.address.postCode}}<br>
					Ocena objekta: {{o.rating}}<br>
					Radno vreme: {{o.workingHours}}</p>

					<p v-else style="font-size:25px">Opis: {{o.description}}. Objekat je zatvoren.<br>
					Tip objekta: {{o.objectType}}<br>
					Lokacija: ({{o.location.geoLength}}, {{o.location.geoWidth}}) {{o.location.address.street}} {{o.location.address.number}}, {{o.location.address.city}}, {{o.location.address.postCode}}<br>
					Ocena objekta: {{o.rating}}<br>
					Radno vreme: {{o.workingHours}}</p>
				</div>
			</div>
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
<template>

    <div class="page-background">
        <div class="page-header">
            <h2 class="header-text">Kreiraj recept</h2>
            <div class="logo-box">
                <img class="logo" src="../assets/img/logo.png" alt="Logo" />
            </div>
        </div>

        <div class="create-form">
            <label for="name" style="top: 0%;left:20%;">Naziv: </label>
            <input class="input-field" id="name" style="top: 7%;left:20%;" v-model="receipt.name" />
            <label for="type" style="top: 18%;left:20%;">Tip recepta: </label>
            <PVAutoComplete id="type" class="autocomplete-field" v-model="receipt.type"
                @complete="calculateFilteredTypes($event)" :suggestions="filteredTypes" :dropdown="true"
                optionLabel="name" forceSelection />

            <div class="list-box">
                <div class="list-header">
                    <h3 class="list-header-text">Lista sastojaka: </h3>
                </div>
                <div class="list-items-box">
                    <ul>
                        <li class="ingredient-list-item" v-for="ingredient in receipt.ingredients" :key="ingredient.id">
                            {{
                                    ingredient.name
                            }} ------------------------ {{
        ingredient.quantity
}} {{
        ingredient.unit
}} </li>
                    </ul>
                </div>
                <button class="add-ingredient-button"
                    @click="this.newIngredient = {}; this.addIngredientDialogVisible = true;">Dodaj sastojak</button>


            </div>

            <label style="top: 45%;left:20%;" for="description">Opis recepta: </label>
            <textarea id="description" class="textarea-field" style="top:52%;left:20%" v-model="receipt.description"
                cols="66" rows="10" />

            <button class="save-button" @click="saveReceipt" label="Sačuvaj recept">Sačuvaj recept</button>

        </div>

        <!-- <div class="card">
            <div class="formgrid grid">
                <div class="field col">
                    <div class="field">
                        <label for="name">Ime recepta</label>
                        <PVInputText id="name" v-model="receipt.name" />
                    </div>
                    <div class="field">
                        <label for="type">Tip recepta</label>
                        <PVAutoComplete id="type" v-model="receipt.type" @complete="calculateFilteredTypes($event)"
                            :suggestions="filteredTypes" :dropdown="true" optionLabel="name" forceSelection />
                    </div>
                </div>
                <div class="flex field col">
                    <PVOrderList v-model="receipt.ingredients">
                        <template #header>
                            <p>Lista sastojaka</p>
                            <PVButton class="center" icon="pi pi-plus"
                                @click="this.newIngredient = {}; this.addIngredientDialogVisible = true;" />
                        </template>
                        <template #item="slotProps">
                            <p>{{ slotProps.item.name }} - {{ slotProps.item.quantity }} - {{ slotProps.item.unit }}</p>
                        </template>
                    </PVOrderList>
                </div>
                <div class="field col">

                </div>

            </div>
            <div class="flex field">
                <label for="description">Opis recepta</label>
                <PVTextarea id="description" v-model="receipt.description" cols="66" rows="10" />
            </div>

            <PVButton icon="pi pi-save" @click="saveReceipt" label="Sačuvaj recept" />


        </div> -->

        <PVDialog header="Dodaj sastojak" v-model:visible="addIngredientDialogVisible">
            <div class="add-ingredient-dialog">
                <label style="top:20%; left:10%">Ime sastojka: </label>
                <input class="input-field" style="top:30%;left:15%;height:7%;width:50%" v-model="newIngredient.name" /> 
                <label style="top:40%; left:10%">Kolicina: </label>
                <input class="input-field" style="top:50%;left:15%;height:7%;width:50%" v-model="newIngredient.quantity" /> 
                <label style="top:60%; left:10%">Jedinica mere: </label>
                <input class="input-field" style="top:70%;left:15%;height:7%;width:50%" v-model="newIngredient.unit" /> 
                <div class="add-ingredient-button-container">
                    <button @click="receipt.ingredients.push(newIngredient);addIngredientDialogVisible=false" class="submit-ingredient-button">Dodaj sastojak</button>

                    
                </div>
            </div>
        </PVDialog>


        <!-- <PVDialog header="Dodaj sastojak" v-model:visible="addIngredientDialogVisible">
            <PVInputText v-model="newIngredient.name"></PVInputText>
            <PVInputText v-model="newIngredient.quantity"></PVInputText>
            <PVInputText v-model="newIngredient.unit"></PVInputText>
            <template #footer>
                <PVButton @click="receipt.ingredients.push(newIngredient); addIngredientDialogVisible = false">
                </PVButton>
            </template>
        </PVDialog> -->

    </div>


</template>


<script>
import axios from 'axios';


export default ({
    data() {
        return {
            receipt: { ingredients: [] },
            addIngredientDialogVisible: false,
            newIngredient: {},
            filteredTypes: [],
            receiptSaved: false,
        }
    },
    methods: {
        logReceipt() {
            console.log(this.receipt)
        },
        async saveReceipt() {
            const response = await axios({
                method: 'post',
                url: 'http://localhost:8090/receiptService/save',
                data: {
                    id: this.receipt.id,
                    name: this.receipt.name,
                    type: this.receipt.type,
                    ingredients: this.receipt.ingredients,
                    description: this.receipt.description
                }
            });
            this.receipt = response.data;
            this.receiptSaved = true;
            console.log(this.receipt)
        },
        async calculateFilteredTypes(event) {
            console.log(event.query)
            const response = await axios({
                method: 'post',
                url: 'http://localhost:8090/receiptTypeService/completeReceiptType',
                data: {
                    query: event.query
                }
            });
            this.filteredTypes = response.data;
        }
    }
});

</script>

<style>
@import '../assets/css/other_pages_style.css';
</style>
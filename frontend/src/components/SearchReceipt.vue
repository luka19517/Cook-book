<template>

    <div class="page-background">
        
        <div class="page-header">
            <h2 class="header-text">Pretrazi recepte</h2>
            <div class="logo-box">
                <img class="logo" src="../assets/img/logo.png" alt="Logo" />
            </div>
        </div>

        <div class="search-box">
            <label for="receipt" style="left:20%;top:0%">Pretraga recepta: </label>

            <PVAutoComplete id="receipt" style="left:20%;top:25%" class="search-field" v-model="receipt"
                @complete="calculateFilteredReceipts($event)" @item-select="selectedReceipt($event.value)"
                :suggestions="filteredReceipts" :dropdown="true" optionLabel="name" />
        </div>

        <div class="receipt-form" v-if="selectionMade">
            <label for="name" style="top: 0%;left:20%;">Naziv: </label>
            <input class="input-field" id="name" style="top: 7%;left:20%;" v-model="receipt.name" disabled="true" />
            <label for="type" style="top: 15%;left:20%;">Tip recepta: </label>
            <input class="input-field" id="name" style="top: 22%;left:20%;" v-model="receipt.type.name"
                disabled="true" />

            <div class="list-box" style="top:0%">
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
            </div>

            <label style="top: 33%;left:20%;" for="description">Opis recepta: </label>
            <textarea id="description" class="textarea-field" style="top:40%;left:20%" v-model="receipt.description"
                cols="66" rows="10" disabled="true" />


        </div>

        <!-- <PVAutoComplete id="receipt" v-model="receipt" @complete="calculateFilteredReceipts($event)"
            :suggestions="filteredReceipts" :dropdown="true" optionLabel="name" forceSelection />

        <div v-if="receipt">
            <div class="formgrid grid">
                <div class="field col">
                    <div class="field">
                        <label for="name">Ime recepta</label>
                        <PVInputText id="name" v-model="receipt.name" />
                    </div>
                    <div class="field">
                        <label for="type">Tip recepta</label>
                        <PVInputText id="type" v-model="receipt.type.name" />
                    </div>
                </div>
                <div class="field col">
                    <PVOrderList v-model="receipt.ingredients">
                        <template #header>
                            Lista sastojaka
                        </template>
                        <template #item="slotProps">
                            <p>{{ slotProps.item.name }} - {{ slotProps.item.quantity }} - {{ slotProps.item.unit }}</p>
                        </template>
                    </PVOrderList>
                </div>
                <div class="field col">

                </div>

            </div>
            <div class="field">
                <label for="description">Opis recepta</label>
                <PVTextarea id="description" v-model="receipt.description" />
            </div>
        </div> -->

    </div>

</template>

<script>
import axios from 'axios';

export default ({
    name: 'SearchReceiptComponent',
    data() {
        return {
            receipt: null,
            filteredReceipts: [],
            selectionMade: false
        }
    },
    methods: {
        async calculateFilteredReceipts(event) {
            console.log(event.query);
            this.selectionMade = false;
            const response = await axios({
                method: 'post',
                url: 'http://localhost:8090/receiptService/completeReceipt',
                data: {
                    query: event.query
                }
            });
            this.filteredReceipts = response.data;
        },
        selectedReceipt(selectedReceipt) {
            this.receipt = { ...selectedReceipt };
            this.selectionMade = true;
        }
    }


})


</script>

<style>
@import '../assets/css/other_pages_style.css';
</style>
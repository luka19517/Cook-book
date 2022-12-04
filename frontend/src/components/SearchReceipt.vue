<template>

    <label for="receipt">Pretrazi recepte</label>
    <PVAutoComplete id="receipt" v-model="receipt" @complete="calculateFilteredReceipts($event)"
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
    </div>


</template>

<script>
import axios from 'axios';

export default ({
    name: 'SearchReceiptComponent',
    data() {
        return {
            receipt: null,
            filteredReceipts: []
        }
    },
    methods: {
        async calculateFilteredReceipts(event) {
            console.log(event.query)
            const response = await axios({
                method: 'post',
                url: 'http://192.168.1.134:8090/receiptService/completeReceipt',
                data: {
                    query: event.query
                }
            });
            this.filteredReceipts = response.data;
        }
    }


})


</script>

<style>
.center {
    display: block;
    margin-left: auto;
    margin-right: auto;
    width: 50%;
}

</style>
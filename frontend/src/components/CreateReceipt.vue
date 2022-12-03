<template>
    <h2>Kreiraj recept</h2>

    <div class="card">
        <div class="formgrid grid">
            <div class="field col">
                <div class="field">
                    <label for="name">Ime recepta</label>
                    <PVInputText id="name" v-model="receipt.name" />
                </div>
                <div class="field">
                    <label for="description">Opis recepta</label>
                    <PVTextarea id="description" v-model="receipt.description" />
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
                <PVButton icon="pi pi-plus" @click="this.newIngredient = {}; this.addIngredientDialogVisible = true;" />
            </div>
        </div>

        <PVButton icon="pi pi-save" @click="saveReceipt" />

    </div>

    <PVDialog header="Dodaj sastojak" v-model:visible="addIngredientDialogVisible">
        <PVInputText v-model="newIngredient.name"></PVInputText>
        <PVInputText v-model="newIngredient.quantity"></PVInputText>
        <PVInputText v-model="newIngredient.unit"></PVInputText>
        <template #footer>
            <PVButton @click="receipt.ingredients.push(newIngredient); addIngredientDialogVisible = false"></PVButton>
        </template>
    </PVDialog>

</template>


<script>
import axios from 'axios';

export default ({
    data() {
        return {
            receipt: { id:null, name: '', type: { id: 'dezert', name: 'Dezert' }, ingredients: [], description: '' },
            addIngredientDialogVisible: false,
            newIngredient: {}
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
            console.log(this.receipt)
        }
    }
});

</script>
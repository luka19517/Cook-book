<template>
    <h2>Kreiraj recept</h2>

    <div class="card">
        <div class="field">
            <label for="name">Sastojak</label>
            <PVInputText id="name" type="text" v-model="ingredient.name" />
        </div>
        <div class="field">
            <label for="quantity">Kolicina</label>
            <PVInputText id="quantity" type="text" v-model="ingredient.quantity" />
        </div>
    </div>

    <PVButton @click="logReceiptItem" label="Sacuvaj sastojak"></PVButton>
    <PVButton @click="logReceipt" label="Sacuvaj recept"></PVButton>

</template>


<script>

export default ({
    data() {
        return {
            receipt: {
                name: '',
                ingredients: []
            },
            ingredient: {}
        }
    },
    methods: {
        logReceiptItem(){
            this.receipt.ingredients.push(this.ingredient);
            console.log(this.ingredient)
        },
        logReceipt(){
            console.log(this.receipt)
        }
    }
});

</script>
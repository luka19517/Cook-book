<template>
    <div class="page-background">
        <PVOrderList v-model="types">
            <template #header>
                Lista tipova recepata
            </template>
            <template #item="slotProps">
                <p>{{ slotProps.item.name }}</p>
            </template>
        </PVOrderList>
    </div>


</template>

<script>
import axios from 'axios';

export default {
    name: 'ReceiptTypeListComponent',
    data() {
        return {
            types: [],
            type: {}
        }
    },
    methods: {
        async loadTypes() {
            const response = await axios({
                method: 'get',
                url: 'http://192.168.1.134:8090/receiptTypeService/getAll'
            });
            this.types = response.data;
            console.log(this.types)
        }
    },
    async mounted() {
        await this.loadTypes()


    }

}


</script>

<style>

@import '../assets/css/other_pages_style.css';

</style>
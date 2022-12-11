<template>
    <div class="page-background">
        <div class="page-header">
            <h2 class="header-text"> Lista tipova recepata</h2>
        </div>
        <PVOrderList v-model="types">
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
                url: 'http://192.168.1.104:8090/receiptTypeService/getAll'
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
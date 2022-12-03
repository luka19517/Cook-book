<template>
    <PVOrderList v-model="types">
        <template #header>
            Lista tipova recepata
        </template >
        <template #item="slotProps">
            <p>{{slotProps.item.name}}</p>
        </template>
    </PVOrderList>


</template>

<script>
import axios from 'axios';

export default {
    name: 'ReceiptTypeListComponent',
    data() {
        return {
            types: []
        }
    },
    methods: {
        async loadTypes() {
            const response = await axios({
                method: 'get',
                url: 'http://localhost:8090/receiptTypeService/getAll'
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
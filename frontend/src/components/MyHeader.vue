<template>
    <PVMenuBar :model="items"></PVMenuBar>
</template>

<script>

export default ({
    data() {
        return {
            items: [
                {
                    label: '',
                    icon: 'pi pi-home',
                    to: '/'
                },
                {
                    label: 'Kreiraj novi recept',
                    icon: 'pi pi-plus',
                    to: '/receipt/create'
                },
                {
                    label: 'Pretrazi recepte',
                    icon: 'pi pi-search'
                },
                {
                    label: 'Konfiguracija',
                    icon: 'pi pi-cog',
                    items: [
                        {
                            label: 'Tipovi recepata',
                            to: '/receipttype/all'
                        }
                    ]
                }
            ]
        }
    }
});
</script>
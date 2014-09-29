
isc.ListGrid.create({
    autoDraw: false,
    fields: [
        {name: "itemName", title: "Item", type: "text"},
        {name: "unitCost", title: "Unit Cost", type: "number"}
    ],
    data: [
        {itemName: "17\" LCD Monitor", unitCost: 330},
        {itemName: "Dr. Grip Pens - Black", unitCost: 4.99}
    ]
});

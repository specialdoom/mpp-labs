using csharp.model;
using csharp.repository;

ProductRepository products = new ProductRepository();

products.Add(new Product()
{
    BarCode = "6420387582007",
    Description = "Notebook",
    Price = 1.25,
    Count = 10
});
products.Add(new Product()
{
    BarCode = "5942328200135",
    Description = "Vitamin Aqua",
    Price = 1.00,
    Count = 10
});

foreach (Product product in products.GetAll())
{
    Console.WriteLine(product);
}
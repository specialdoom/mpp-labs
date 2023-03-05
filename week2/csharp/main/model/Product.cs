namespace csharp.model
{
    public class Product : IIdentifiable<string>
    {
        public string BarCode { get; set; }
        public string Description { get; set; }
        public double Price { get;set; }
        public int Count { get; set; }

        public Product()
        {
            BarCode = string.Empty;
            Description = string.Empty;
            Price = 0.00;
            Count = 0;
        }

        public Product(string id, string description, double price, int count)
        {
            BarCode = id;
            Description = description;
            Price = price;
            Count = count;
        }

        public string getId()
        {
            return BarCode;
        }

        public void setId(string id)
        {
            BarCode = id;
        }

        public override string ToString()
        {
            return $"|{BarCode}| {Description}; {Price}$; {Count} pieces;";
        }
    }
}

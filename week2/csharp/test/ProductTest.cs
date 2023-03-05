using csharp.model;

namespace test
{
    [TestClass]
    public class ProductTest
    {
        [TestMethod]
        public void WhenCallingDefaultConstructor_ShouldCreateEmptyProduct()
        {
            Product product = new();

            Assert.AreEqual("", product.BarCode);
            Assert.AreEqual("", product.Description);
            Assert.AreEqual(0.00, product.Price);
            Assert.AreEqual(0, product.Count);
        }

        [TestMethod]
        public void WhenCallingParamsConstructor_ShouldCreateProductWithSpecifiedParams()
        {
            Product product = new()
            {
                BarCode = "1234",
                Description = "Description",
                Price = 2.56,
                Count = 5
            };

            Assert.AreEqual("1234", product.BarCode);
            Assert.AreEqual("Description", product.Description);
            Assert.AreEqual(2.56, product.Price);
            Assert.AreEqual(5, product.Count);
        }
    }
}
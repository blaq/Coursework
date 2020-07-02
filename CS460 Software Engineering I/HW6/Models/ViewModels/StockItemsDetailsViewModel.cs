using System;
using HW6.Models;

namespace HW6.Models.ViewModels
{
    public class StockItemDetailsViewModel
    {
        public StockItemDetailsViewModel(StockItem item)
        {
            StockItemID = item.StockItemID;
            StockItemName = item.StockItemName;
            Size = item.Size;
            RecommendedRetailPrice = item.RecommendedRetailPrice;
            TypicalWeightPerUnit = item.TypicalWeightPerUnit;
            LeadTimeDays = item.LeadTimeDays;
            ValidFrom = item.ValidFrom;
            CustomFields = item.CustomFields;
            Tags = item.Tags;

            SupplierName = item.Supplier.SupplierName;
            SupplierNumber = item.Supplier.PhoneNumber;
            FaxNumber = item.Supplier.FaxNumber;
            WebsiteURL = item.Supplier.WebsiteURL;
            PrimaryContact = item.Supplier.PrimaryContactPersonID;
            //PrimaryContact = Person.PersonID(item.Supplier.PrimaryContactPersonID);

            Orders = item.OrderLines.Count;
        }

        public int StockItemID { get; private set; }
        public string StockItemName { get; private set; }
        public string Size { get; private set; }
        public decimal? RecommendedRetailPrice { get; private set; }
        public decimal TypicalWeightPerUnit { get; private set; }
        public int LeadTimeDays { get; private set; }
        public DateTime ValidFrom { get; private set; }
        public string CustomFields { get; private set; }
        public string Tags { get; private set; }

        public string SupplierName { get; private set; }
        public string SupplierNumber { get; private set; }
        public string FaxNumber { get; private set; }
        public string WebsiteURL { get; private set; }
        public int PrimaryContact { get; private set; }

        public int Orders { get; private set; }
    }
}